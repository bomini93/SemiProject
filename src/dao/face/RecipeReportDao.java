package dao.face;

import java.sql.Connection;

import dto.Report_Recipe_Table;

public interface RecipeReportDao {

	public int insert(Connection conn, Report_Recipe_Table report_recipe_table);

}
