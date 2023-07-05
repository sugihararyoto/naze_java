//パッケージ名の宣言
package work3_3;
/**
 * ジャンケンのプレイヤーを表すクラス
 */
/*
 * クラス名:PlayerClass
 * 概要  :プレイヤークラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.26
 */
public class PlayerClass {
	//ジャンケンの手を表す定数
	//グー
	public static final int STONE_NUMBER = 0;
	//チョキ
	public static final int SCISSORS_NUMBER = 1;
	//パー
	public static final int PAPER_NUMBER = 2;
	
	/*
	 * プレイヤークラスの属性
	 */
	/** プレイヤーの名前  */
	private String playerName;
	
	/** プレイヤーの勝った回数 */
	private int winCount = 0;
	
	/*
	 * 関数名：PlayerClass
	 * 概要：コンストラクタ
	 * 引数：String nameString
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public PlayerClass(String nameString) {
		//フィールドに引数nameStringの文字列を代入する
		playerName = nameString;
	}
	
	/*
	 * プレイヤークラスの操作
	 */
	/*
	 * 関数名：showHand
	 * 概要：ジャンケンの手を出す
	 * 引数：なし
	 * 戻り値：playerHand
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public int showHand() {
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
			playerHand = STONE_NUMBER;
			
		// randomNumberが1.0以上2.0未満の場合
		} else if (randomNumber < 2) {
			// チョキを出す
			playerHand = SCISSORS_NUMBER;
			
		// randomNumberが2.0以上3.0未満の場合
		} else if (randomNumber < 3) {
			// パーを出す
			playerHand = PAPER_NUMBER;
			
		}
		
		// プレイヤーの出した手を返却する
		return playerHand;
	}
	
	/*
	 * 関数名：notifyResult
	 * 概要：審判から勝敗を聞く。true = 勝ち、false = 負け
	 * 引数：boolean resultNumber
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public void notifyResult(boolean resultNumber) {
		// 勝った場合
		if (resultNumber == true) {
			// 勝った回数を増やす
			winCount++;
		}
	}
	
	/*
	 * 関数名：getWinCount
	 * 概要：自分の勝った回数を答える
	 * 引数：なし
	 * 戻り値：winCount
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public int getWinCount() {
		// 勝った回数を返却する
		return winCount;
	}
	
	/*
	 * 関数名：getName
	 * 概要：プレイヤーの名前を返却する
	 * 引数：なし
	 * 戻り値：playerName
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public String getName() {
		// プレイヤーの名前を返却する
		return playerName;
	}

}
