package dao.face;

import java.sql.Connection;

public interface RestCntDao {

	int selectCntAll(Connection conn);
	
	int selectCntKorean(Connection conn);

	int selectCntSnack(Connection conn);

	int selectCntJapan(Connection conn);

	int selectCntChina(Connection conn);

	int selectCntWestern(Connection conn);

	int selectCntEtc(Connection conn);

}
