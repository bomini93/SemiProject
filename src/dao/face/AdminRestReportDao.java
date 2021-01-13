package dao.face;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface AdminRestReportDao {

	public List<Map> selectAll(Connection conn);

}
