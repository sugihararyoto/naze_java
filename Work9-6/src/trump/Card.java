// パッケージ名の宣言
package trump;
/**
 * トランプのカードを表すクラス
 */
/*
 * クラス名:Card
 * 概要  :カードクラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.28
 */
public class Card {
	
	/** スペードを表す定数*/
	public static final int SUIT_SPADE = 1;
	
	/** ダイヤを表す定数 */
	public static final int SUIT_DIAMOND = 2;
	
	/** クラブを表す定数 */
	public static final int SUIT_CLUB = 3;
	
	/** ハートを表す定数 */
	public static final int SUIT_HEART = 4;
	
	/** スートの数 */
	public static final int SUIT_NUMBER = 4;
	
	/** 値の数 */
	public static final int CARD_NUMBER = 13;
	
	/** カードの示すスート */
	protected int cardSuit;
	
	/** カードの示す数 */
	protected int cardNumber;
	
	/*
	 * 関数名：Card
	 * 概要：コンストラクタ
	 * 引数：int cardSuit, int cardNumber
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public Card(int cardSuit, int cardNumber) {
		// フィールドに引数の値を代入する
		this.cardSuit = cardSuit;
		// フィールドに引数の値を代入する
		this.cardNumber = cardNumber;
	}
	/*
	 * 関数名：getNumber
	 * 概要：数字を見る
	 * 引数：なし
	 * 戻り値：cardNumber
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public int getNumber() {
		// カードの示す数を返却する
		return cardNumber;
	}
	
	/*
	 * 関数名：getSuit
	 * 概要：スートを見る
	 * 引数：なし
	 * 戻り値：cardSuit
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.28
	 */
	public int getSuit() {
		// カードの示すスートを返却する
		return cardSuit;
	}
	
	/*
	 * 関数名：toString
	 * 概要：カードを文字列で表現する
	 * 引数：なし
	 * 戻り値：textString.toString()
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	@Override public String toString() {
		// 文字列を格納する変数を生成する
		StringBuffer textString = new StringBuffer();
		
		// スートの表示
		switch (cardSuit) {
			// スペードの場合
			case SUIT_SPADE :
				// 文字列に"S"を連結する
				textString.append("S");
				// switch文から抜ける
				break;
			// ダイヤモンドの場合
			case SUIT_DIAMOND :
				// 文字列に"D"を連結する
				textString.append("D");
				// switch文から抜ける
				break;
			// クラブの場合
			case SUIT_CLUB:
				// 文字列に"C"を連結する
				textString.append("C");
				// switch文から抜ける
				break;
			// ハートの場合
			case SUIT_HEART :
				// 文字列に"H"を連結する
				textString.append("H");
				// switch文から抜ける
				break;
			// それ以外の場合
			default :
				// switch文から抜ける
				break;
		}
		
		// 数の表示
		switch (cardNumber) {
			// 1の場合
			case 1 :
				// 文字列に"A"を連結する
				textString.append("A");
				// switch文から抜ける
				break;
			// 10の場合
			case 10 :
				// 文字列に"T"を連結する
				textString.append("T");
				// switch文から抜ける
				break;
			// 11の場合
			case 11 :
				// 文字列に"J"を連結する
				textString.append("J");
				// switch文から抜ける
				break;
			// 12の場合
			case 12 :
				// 文字列に"Q"を連結する
				textString.append("Q");
				// switch文から抜ける
				break;
			// 13の場合
			case 13 :
				// 文字列に"K"を連結する
				textString.append("K");
				// switch文から抜ける
				break;
			// それ以外の場合
			default :
				// 文字列に値を連結する
				textString.append(cardNumber);
				// switch文から抜ける
				break;
		}
		// 文字列を返却する
		return textString.toString();
	}

}
