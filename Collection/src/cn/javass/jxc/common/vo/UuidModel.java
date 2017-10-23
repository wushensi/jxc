package cn.javass.jxc.common.vo;

import java.io.Serializable;

/**
 * 这个东西本身就是为了生成uuid，所以他没有uuid这个字段
 * 记录的讲师下一个直接返回的，如果已经有3个UserModel，相当于记录4
 * @author wushensi
 * 
 *
 */
public class UuidModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modelName;
	private int currentNum;
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getCurrentNum() {
		return currentNum;
	}
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((modelName == null) ? 0 : modelName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UuidModel other = (UuidModel) obj;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		return true;
	}
	
	
}
