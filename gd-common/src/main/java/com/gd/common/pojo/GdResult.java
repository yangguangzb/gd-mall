package com.gd.common.pojo;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * gd自定义响应结构
 * @description
 * @author zhangbiao
 * @time 2018-6-21 下午7:36:36
 */
public class GdResult {
	
	//定义jackson对象
	private static final ObjectMapper MAPPER=new ObjectMapper();
	
	//响应业务状态
	private Integer status;
	
	//响应消息
	private String msg;
	
	//响应中的数据
	private Object data;
	
	public static GdResult build(Integer status, String msg, Object data) {
        return new GdResult(status, msg, data);
    }

    public static GdResult ok(Object data) {
        return new GdResult(data);
    }

    public static GdResult ok() {
        return new GdResult(null);
    }

    public GdResult() {

    }

    public static GdResult build(Integer status, String msg) {
        return new GdResult(status, msg, null);
    }

    public GdResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public GdResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	/**
     * 将json结果集转化为GdResult对象
     * @param jsonData json数据
     * @param clazz GdResult中的object类型
     * @return
     */
    public static GdResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, GdResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * @param json
     * @return
     */
    public static GdResult format(String json) {
        try {
            return MAPPER.readValue(json, GdResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static GdResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

	
}
