package dao.face;

import java.sql.Connection;

import dto.Report_rest_table;
import dto.Rest_info;

public interface RestReportDao {

	public int reportRest(Connection conn, Report_rest_table rrt);

	


}
