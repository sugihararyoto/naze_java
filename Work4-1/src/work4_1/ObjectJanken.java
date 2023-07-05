//パッケージ名の宣言
package work4_1;
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
		MurataClass playerMurata = new MurataClass("村田さん");
		
		// プレイヤー2（山田さん）の生成
		YamadaClass playerYamada = new YamadaClass("山田さん");
		
		// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		judgeSaito.startJanken(playerMurata, playerYamada);
		
		
	}

}
