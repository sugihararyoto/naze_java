//パッケージ名の宣言
package work4_2;
/*
 * クラス名:MurataClass
 * 概要  :プレイヤークラスから派生した村田さんクラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.26
 */
public class MurataClass extends PlayerClass {
	
	/*
	 * 関数名：MurataClass
	 * 概要：コンストラクタ
	 * 引数：String nameString
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public MurataClass(String nameString) {
		//プレイヤークラスのコンストラクタの呼出し
		super(nameString);
	}
	/*
	 * 関数名：showHand
	 * 概要：ジャンケンの手を出す
	 * 引数：なし
	 * 戻り値：playerHand
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public int showHand() {
		
		// グーを出す
		int playerHand = STONE_NUMBER;
		
		// プレイヤーの出した手を返却する
		return playerHand;
	}

}
