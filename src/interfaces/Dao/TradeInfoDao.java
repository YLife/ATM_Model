package interfaces.Dao;

import java.util.List;

import entity.TradeInfo;

/**
 * 此接口对TradeInfo的持久化操作进行抽象
 * @author YangLun
 *
 */
public interface TradeInfoDao extends BaseDao<TradeInfo> {
	
	/**
	 * 通过卡号查记录
	 * @param cardId
	 * @return	List<TradeInfo>
	 */
	List<TradeInfo> queryByCardId(String cardId);
}
