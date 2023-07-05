//パッケージ名の宣言
package work5_2;
/**
 * ランダムに手を決める戦略クラス
 */
/*
 * クラス名:RandomTactics
 * 概要  :ランダムに手を決める戦略クラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.26
 */
public class RandomTactics implements JankenTactics{
	/*
	 * 関数名：readTactics
	 * 概要：戦略を読み、ジャンケンの手を得る
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public int readTactics() {
		// 乱数を格納するための変数
		double randomNumber = 0;
		
		// ■■■■■■■■■■■■■■■■
		//   プレイヤーが何を出すか決める
		// ■■■■■■■■■■■■■■■■
		int playerHand = 0;
		
		// 0以上3未満の少数として乱数を得る
		randomNumber = Math.random() * 3;
		
		// randomNumberが0.0以上1.0未満の場合
		if (randomNumber < 1) {
			// グーを出す
			playerHand = PlayerClass.STONE_NUMBER;
			
		// randomNumberが1.0以上2.0未満の場合
		} else if (randomNumber < 2) {
			// チョキを出す
			playerHand = PlayerClass.SCISSORS_NUMBER;
			
		// randomNumberが2.0以上3.0未満の場合
		} else if (randomNumber < 3) {
			// パーを出す
			playerHand = PlayerClass.PAPER_NUMBER;
			
		}
		
		// プレイヤーの出した手を返却する
		return playerHand;
	}

}
