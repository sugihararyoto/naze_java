//パッケージ名の宣言
package work5_2;
/**
 * 順番に手を決める戦略クラス
 */
/*
 * クラス名:RandomTactics
 * 概要  :グー・チョキ・パーを順番に手を決める戦略クラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.26
 */
public class CyclicTactics implements JankenTactics{
	// 順番を表すための変数
	private int orderNumber = 0;
	/*
	 * 関数名：readTactics
	 * 概要：戦略を読み、ジャンケンの手を得る
	 * 引数：なし
	 * 戻り値：playerHand
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public int readTactics() {
		
		// ■■■■■■■■■■■■■■■■
		//   プレイヤーが何を出すか決める
		// ■■■■■■■■■■■■■■■■
		int playerHand = 0;
		
		// 最初、またはパーを出した後の場合
		if (orderNumber == 0) {
			// グーを出す
			playerHand = PlayerClass.STONE_NUMBER;
			// orderNumberをインクリメント
			orderNumber++;
			
		// グーを出した後の場合
		} else if (orderNumber == 1) {
			// チョキを出す
			playerHand = PlayerClass.SCISSORS_NUMBER;
			// orderNumberをインクリメント
			orderNumber++;
			
		// チョキを出した後の場合
		} else if (orderNumber == 2) {
			// パーを出す
			playerHand = PlayerClass.PAPER_NUMBER;
			// orderNumberに0を代入する
			orderNumber = 0;
			
		}
		
		// プレイヤーの出した手を返却する
		return playerHand;
	}

}
