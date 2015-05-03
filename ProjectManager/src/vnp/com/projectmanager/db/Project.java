package vnp.com.projectmanager.db;

import android.content.Context;

import com.acv.cheerz.db.SkypeTable;

public class Project extends SkypeTable {

	public Project(Context context, Class provider) {
		super(context, provider);
		addColumns("user");
		addColumns("projectname");
		addColumns("status");
	}
}