// パッケージ名の宣言
package trump;
/**
 * ジョーカーを表すクラス
 */
/*
 * クラス名:Joker
 * 概要  :ジョーカークラス
 * setNumber(),setSuit()メソッドを利用することで、
 * どのようなカードとしても扱うことができる
 * 作成者:R.Sugihara
 * 作成日:2023.06.28
 */
public class Joker extends Card {
	/*
	 * 関数名：Joker
	 * 概要：コンストラクタ
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.28
	 */
	public Joker() {
		/*
		 *  デフォルトでは何の値・スートも表さない
		 *  getNumber(),getSuit()は0を返す
		 */
		super(0, 0);
	}
	
	/*
	 * 関数名：setNumber
	 * 概要：数を変更する
	 * 引数：int cardNumber
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.28
	 */
	public void setNumber(int cardNumber) {
		// フィールドに引数の値を代入する
		this.cardNumber = cardNumber;
	}
	
	/*
	 * 関数名：setSuit
	 * 概要：スートを変更する
	 * 引数：int cardSuit
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.28
	 */
	public void setSuit(int cardSuit) {
		// フィールドに引数の値を代入する
		this.cardSuit = cardSuit;
	}
	
	/*
	 * 関数名：toString
	 * 概要：カードを文字列で表現する
	 * 引数：なし
	 * 戻り値："JK"
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.28
	 */
	@Override public String toString() {
		// 文字列JKを返却する
		return "JK";
	}
	

}
