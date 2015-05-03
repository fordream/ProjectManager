package vnp.com.projectmanager.db;

import android.content.ContentValues;
import android.content.Context;

import com.acv.cheerz.db.SkypeTable;

public class User extends SkypeTable {

	public User(Context context, Class provider) {
		super(context, provider);
		addColumns("user");
		addColumns("password");
		addColumns("timeupdate");
	}

	public boolean login(String user, String password) {
		ContentValues values = new ContentValues();
		values.put("user", user);
		values.put("password", password);
		values.put("timeupdate", System.currentTimeMillis() + "");
		String where = String.format("%s ='%s'", "user", user);
		String whereCheck = String.format("%s ='%s' and %s ='%s'", "user", user, "password", password);
		if (has(where)) {
			if (has(whereCheck)) {
				return true;
			} else {
				return false;
			}
		} else {
			getContext().getContentResolver().insert(getContentUri(), values);
			return true;
		}
	}
}