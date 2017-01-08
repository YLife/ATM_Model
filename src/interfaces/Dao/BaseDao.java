package interfaces.Dao;

import java.util.List;

/**
 * 创建泛型接口，简化DAO层接口的定义
 * @author YangLun
 * @param <E>		
 */
public interface BaseDao<E> {
	
	/**
	 * 通过id查询记录
	 * @param id
	 * @return E
	 */
	E queryById(Object id);
	
	/**
	 * 查询所有记录
	 * @return List<E>
	 */
	List<E> queryAll();
	
	/**
	 * 插入一条记录
	 * @param entity
	 * @return	受影响的行
	 */
	int save(E entity);
	
	/**
	 * 修改记录
	 * @param entity
	 * @return 受影响的行
	 */
	int update(E entity);
	
	/**
	 * 删除一条记录
	 * @param id
	 * @return 受影响的行
	 */
	int delete(Object id);
	
}
