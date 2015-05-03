package vnp.com.projectmanager.fragment;

import vnp.com.projectmanager.R;
import vnp.com.projectmanager.db.PMDBProvider;
import vnp.com.projectmanager.db.User;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.vnp.core.base.BaseFragment;
import com.vnp.core.common.CommonAndroid;

//vnp.com.projectmanager.fragment.LoginFragment
public class LoginFragment extends BaseFragment implements OnClickListener {

	@Override
	public int getLayOut() {
		return R.layout.login;
	}

	@Override
	public void init(View view) {
		view.setOnClickListener(this);
		view.findViewById(R.id.login_btn).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		EditText login_user = CommonAndroid.getView(getView(), R.id.login_user);
		EditText login_password = CommonAndroid.getView(getView(), R.id.login_password);
		String message = "";
		if (CommonAndroid.isBlank(login_user.getText().toString())) {
			message = getString(R.string.error_user);
		} else if (CommonAndroid.isBlank(login_password.getText().toString())) {
			message = getString(R.string.error_password);
		}

		if (CommonAndroid.isBlank(message)) {
			//
			User user = new User(getActivity(), PMDBProvider.class);
			if (user.login(login_user.getText().toString().trim(), login_password.getText().toString().trim())) {
				CommonAndroid.showDialog(getActivity(), "success", null);
			} else {
				CommonAndroid.showDialog(getActivity(), "fail", null);
			}
		} else {
			CommonAndroid.showDialog(getActivity(), message, null);
		}
	}
}
