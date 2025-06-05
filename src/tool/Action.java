package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Actionクラスの基幹クラスを作成
public abstract class Action {

    // すべてのActionクラスがもつメソッド「execute」も作る
	public abstract String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception;
}
