package impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DbUtil;
import entity.TradeInfo;
import interfaces.Dao.EntityResultSetMapping;
import interfaces.Dao.TradeInfoDao;

public class TradeInfoImpl extends DbUtil implements TradeInfoDao {
	
	//创建一个内部类，用于将rs中一行记录映射为一个实体
	private class TradeInfoResultSetMappingImpl implements EntityResultSetMapping<TradeInfo>{

		@Override
		public TradeInfo mapping(ResultSet rs) throws SQLException {
			return new TradeInfo(rs.getInt("tradeId"), rs.getString("cardId"), rs.getInt("tradeType"), 
					rs.getTimestamp("tradeTime"), rs.getDouble("tradeMoney"), rs.getString("remark"));
		}
		
	}
	@Override
	public TradeInfo queryById(Object id) {
		String sql = "select * from tradeinfo where tradeId = ?";
		List<TradeInfo> list = super.excuteQuery(new TradeInfoResultSetMappingImpl(), sql, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<TradeInfo> queryAll() {
		String sql = "select * from tradeinfo";
		return super.excuteQuery(new TradeInfoResultSetMappingImpl(), sql);
	}

	@Override
	public int save(TradeInfo entity) {
		String sql = "insert into tradeinfo(tradeId , cardId , tradeType , tradeDate , tradeMoney , remark) "
				+ "values(? , ? , ? , ? , ? , ?)";
		return super.excuteUpdate(sql, entity.getTradeId() , entity.getCardId() , entity.getTradeType() , 
				entity.getTradeTime() , entity.getTradeMoney() , entity.getRemark());
	}

	@Override
	public int update(TradeInfo entity) {
		String sql = "update tradeInfo set cardId=?,tradeType=?,tradeDate=?,tradeMoney=?,remark=?"
				+ " where tradeId = ?";
		return super.excuteUpdate(sql, entity.getCardId(),entity.getTradeType(),entity.getTradeTime(),
				entity.getTradeMoney(),entity.getRemark(),entity.getTradeId());
	}

	@Override
	public int delete(Object id) {
		String sql = "delete from tradeinfo where tradeId = ?";
		return super.excuteUpdate(sql, id);
	}

	@Override
	public List<TradeInfo> queryByCardId(String cardId) {
		String sql = "select * from tradeinfo where cardId = ?";
		return super.excuteQuery(new TradeInfoResultSetMappingImpl(), sql, cardId);
	}

}
