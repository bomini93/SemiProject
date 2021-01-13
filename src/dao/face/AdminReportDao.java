package dao.face;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.Report_Recipe_Table;

public interface AdminReportDao {

	public int selectCntAll(Connection connection);

	public List<Report_Recipe_Table> selectList(Connection connection, Paging paging);

}
