package cn.javass.jxc.common.dao.dao;

/**
 * 关于modelName
 * 它本身应该是个离散值，即只有几种取值可能，如果用String作为参数，很明显变成范围值了。
 * 
 * 某一个类的对象，只有那么几种取值，不可能更多了。Enumeration提供解决方案
 * 
 * 使用Enum把连续取值变成离散取值
 * 
 * @author wushensi
 *
 */
public interface UuidDAO {
	public String getNextNum(String modelName);
}
