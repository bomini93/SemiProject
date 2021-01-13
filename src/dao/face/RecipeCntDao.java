package dao.face;

import java.sql.Connection;

public interface RecipeCntDao {

	int selectCntAll(Connection connection);

	int selectCntpork(Connection connection);

	int selectCntbeef(Connection connection);

	int selectCntchicken(Connection connection);

	int selectCntduck(Connection connection);

	int selectCntseafood(Connection connection);

	int selectCntgreen(Connection connection);

	int selectCntothers(Connection connection);

}
