package vnp.com.projectmanager.db;

import com.acv.cheerz.db.DBDatabaseHelper;
import com.acv.cheerz.db.DBProvider;

//vnp.com.projectmanager.db.PMDBProvider
public class PMDBProvider extends DBProvider {

	@Override
	public void addTable(DBDatabaseHelper arg0) {
		arg0.addTable(new User(getContext(), getClass()));
		arg0.addTable(new Project(getContext(), getClass()));
	}

	@Override
	public int getVersionDB() {
		return 1;
	}
}