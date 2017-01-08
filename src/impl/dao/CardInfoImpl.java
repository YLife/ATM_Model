package impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DbUtil;
import entity.CardInfo;
import interfaces.Dao.CardInfoDao;
import interfaces.Dao.EntityResultSetMapping;

public class CardInfoImpl extends DbUtil implements CardInfoDao {
	
	/**
	 * 创建一个内部类，用于将rs中的一行记录映射为CardInfo实体
	 * @author YangLun
	 *
	 */
	private class CardInfoResultSetMappingImpl implements EntityResultSetMapping<CardInfo>{

		@Override
		public CardInfo mapping(ResultSet rs) throws SQLException {
			return new CardInfo(rs.getString("cardId"), rs.getString("pwd"), rs.getDouble("balance"));
		}
		
	}
	@Override
	public CardInfo queryById(Object id) {
		String sql = "select * from cardInfo where cardId = ?";
		List<CardInfo> list = super.excuteQuery(new CardInfoResultSetMappingImpl(),sql, id);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<CardInfo> queryAll() {
		String sql = "select * from cardinfo";
		List<CardInfo> list = super.excuteQuery(new CardInfoResultSetMappingImpl(), sql);
		return list;
	}

	@Override
	public int save(CardInfo entity) {
		String sql = "insert into cardInfo(cardId , pwd , balance) values(? , ? ,?)";
		return super.excuteUpdate(sql, entity.getCardId() , entity.getPwd() , entity.getBalance());
	}

	@Override
	public int update(CardInfo entity) {
		String sql = "update cardinfo set pwd = ? , balance = ? where cardId = ? ";
		return super.excuteUpdate(sql, entity.getPwd() , entity.getBalance() , entity.getCardId());
	}

	@Override
	public int delete(Object id) {
		String sql = "delete from cardinfo where cardId = ?";
		return super.excuteUpdate(sql, id);
	}

}
