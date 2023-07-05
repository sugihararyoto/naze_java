// パッケージ名の宣言
package work7_2;
import java.util.ArrayList;

import javax.smartcardio.Card;
/**
 * ばば抜きの手札を表すクラス
 */
/*
 * クラス名:Hand
 * 概要  :手札クラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.27
 */
public class Hand {
	/** 手札にあるカードを保持するためのリスト */
	private ArrayList handCard = new ArrayList();
	
	/*
	 * 関数名：addCard
	 * 概要：カードを加える
	 * 引数：Card oneCard
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public void addCard(Card oneCard) {
		// カードをリストの最後に追加する
		handCard.add(oneCard);
	}
	
	/*
	 * 関数名：pickCard
	 * 概要：カードを引く。
	 * 引数：なし
	 * 戻り値：pickedCard
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public Card pickCard() {
		// カードを引く
		Card pickedCard = (Card) handCard.remove(0);
		// カードを引いて返却する
		return pickedCard;
	}
	
	/*
	 * 関数名：shuffleCard
	 * 概要：シャッフルする
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public void shuffleCard() {
		// 手札の枚数を取得
		int handNumber = handCard.size();
		
		// カードを抜き出す位置
		int cardPosition;
		
		// カードをランダムに抜き取って最後に加える動作を繰り返す
		for (int count = 0; count < handNumber * 2; count++) {
			// ランダムな位置からカードを1枚抜き取る（位置を代入）
			cardPosition = (int) (Math.random() * handNumber);
			// ランダムな位置からカードを1枚抜き取る
			Card pickedCard = (Card) handCard.remove(cardPosition);
			
			// 抜き取ったカードを最後に加える
			handCard.add(pickedCard);
		}
		
	}
	
	/*
	 * 関数名：getNumberOfCards
	 * 概要：枚数を数える
	 * 引数：なし
	 * 戻り値：handCard.size()
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public int getNumberOfCards() {
		// 手札にあるカードの枚数を返却する
		return handCard.size();
	}
	
	/*
	 * 関数名：getNumberOfCards
	 * 概要：同じ数のカードを探す
	 * 引数：なし
	 * 戻り値：handCard.size()
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public Card[] findSameNumberCard() {
		// 手札にあるカードの要素数を代入する
		int numberOfCards = handCard.size();
		// 配列を生成し、nullを参照
		Card[] sameCards = null;
		
		// 手札にカードが1枚もない場合は何もしない
		if (numberOfCards > 0) {
			// 最後に追加されたカードを取得する
			int lastIndex = numberOfCards - 1;
			// 最後に追加されたカードの要素を代入する
			Card lastAddedCard = (Card) handCard.get(lastIndex);
			
			// 最後に追加されたカードの表示を取得する
			int lastAddedCardNum = lastAddedCard.getNumber();
			
			// 最後に追加されたカードの値分繰り返す
			for (int index = 0; index < lastIndex; index++) {
				// 手札のカードの要素を代入する
				Card allCard = (Card) handCard.get(index);
				// 最後に追加されたカードと同じカードが見つかった場合
				if (allCard.getNumber() == lastAddedCardNum) {
					// 見つかった組み合わせをsameCardsに格納する
					sameCards = new Card[2];
					// 最後に追加されたカードを取り除く
					sameCards[0] = (Card) handCard.remove(lastIndex);
					// カードを取り除く
					sameCards[1] = (Card) handCard.remove(index);
					// for文から抜ける
					break;
				}
				
				// 同じ数の組み合わせが見つからなかった場合、
				// sameCardsはnullのままとなる
				
			}
		}
		// 同じ数のカードを返却する
		return sameCards;
	}
	
	/*
	 * 関数名：toString
	 * 概要：手札にあるカードを文字列で表現する
	 * 引数：なし
	 * 戻り値：textString.toString()
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	@Override public String toString() {
		// 文字列を格納する変数を生成する
		StringBuffer textString = new StringBuffer();
		
		// 要素数を代入する
		int handSize = handCard.size();
		// 0より大きい場合
		if (handSize > 0) {
			// 要素数分繰り返す
			for (int index = 0; index < handSize; index++) {
				// 手札にあるカードの要素を代入する
				Card oneCard = (Card) handCard.get(index);
				// 文字列にoneCardの要素を連結する
				textString.append(oneCard);
				// 文字列に" "を連結する
				textString.append(" ");
			}
		}
		// 文字列を返却する
		return textString.toString();
	}


}
