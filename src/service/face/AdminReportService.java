package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Report_Recipe_Table;

public interface AdminReportService {

	public Paging getPaging(HttpServletRequest req);

	public List<Report_Recipe_Table> getList(Paging paging);

}
