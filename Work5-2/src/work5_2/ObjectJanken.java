//パッケージ名の宣言
package work5_2;
/**
 * オブジェクト指向によるジャンケンプログラム
 */
/*
 * クラス名:ObjectJanken
 * 概要  :オブジェクト指向ジャンケンクラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.26
 */
public class ObjectJanken {
	/*
	 * 関数名：main
	 * 概要：ジャンケンをするためのメインメソッド
	 * 引数：String[] args
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public static void main(String[] args) {
		// 審判（斎藤さん）のインスタンス生成
		JudgeClass judgeSaito = new JudgeClass();
		
		// プレイヤー1（村田さん）の生成
		PlayerClass playerMurata = new PlayerClass("村田さん");
		
		// 村田さんに渡す戦略クラスを生成する
		JankenTactics murataTactics = new CyclicTactics();
		
		// 村田さんに戦略クラスを渡す
		playerMurata.setTactics(murataTactics);
		
		// プレイヤー2（山田さん）の生成
		PlayerClass playerYamada = new PlayerClass("山田さん");
		
		// 山田さんに渡す戦略クラスを生成する
		JankenTactics yamadaTactics = new RandomTactics();
		
		// 山田さんに戦略クラスを渡す
		playerYamada.setTactics(yamadaTactics);
		
		// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		judgeSaito.startJanken(playerMurata, playerYamada);
		
		
	}

}
