// パッケージ名の宣言
package fantan;
import trump.Card;
import trump.Table;
/**
 * 七並べのテーブルを表すクラス
 */
/*
 * クラス名:FantanTable
 * 概要  :七並べテーブルクラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.29
 */
public class FantanTable implements Table{
	/** カードを並べるテーブルを表す2次元配列 */
	private Card[][] cardTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];
	
	/*
	 * 関数名：putCard
	 * 概要：カードを置く
	 * 引数：Card[] oneCard
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	public void putCard(Card[] oneCard) {
		// テーブルにカードを置く
		cardTable[(oneCard[0].getSuit() - 1)][(oneCard[0].getNumber() - 1)] = oneCard[0];
	}
	
	/*
	 * 関数名：getCards
	 * 概要：カードを見る。
	 * 引数：なし
	 * 戻り値：cardTable
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	public Card[][] getCards() {
		// 返却するための配列を新たに生成する
		Card[][] returnTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];
		// 返却する配列にコピーするための繰り返し文
		for (int i = 0; i < Card.SUIT_NUMBER; i++) {
			// 配列の内容をコピーする
			System.arraycopy(cardTable[i], 0, returnTable[i], 0, Card.CARD_NUMBER);
		}
		// テーブルに置かれたカードを返却する
		return returnTable;
	}
	
	/*
	 * 関数名：toString
	 * 概要：テーブルを文字列で表現する
	 * 引数：なし
	 * 戻り値：textString.toString()
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	@Override public String toString() {
		// 文字列を格納する変数を生成する
		StringBuffer textString = new StringBuffer();
		
		// Card.SUIT_NUMBERの値分繰り返す
		for (int i = 0;i < Card.SUIT_NUMBER; i++) {
			// Card.CARD_NUMBERの値分繰り返す
			for (int k = 0; k < Card.CARD_NUMBER; k++) {
				
				// nullの場合
				if (cardTable[i][k] == null) {
					// 文字列に".."を連結する
					textString.append("..");
				// カードが存在する場合
				} else {
					// 文字列にテーブルのカードを連結する
					textString.append(cardTable[i][k]);
				}
				// 文字列に半角スペースを連結する
				textString.append(" ");
			}
			// 文字列に改行文字を連結する
			textString.append("\n");
		}
		// 文字列を返却する
		return textString.toString();
	}
	

}