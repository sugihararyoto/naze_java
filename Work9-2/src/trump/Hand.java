// パッケージ名の宣言
package trump;
// importする
import java.util.ArrayList;
/**
 * 手札を表すクラス
 */
/*
 * クラス名:Hand
 * 概要  :手札クラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.28
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
	 * 関数名：lookCard
	 * 概要：カードを見る
	 * 引数：int cardPosition
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	public Card lookCard(int cardPosition) {
		// 変数を生成し、nullを代入する
		Card lookingCard = null;
		
		// 引数で指定された位置が妥当であるかチェックする
		if ((0 <= cardPosition) && (cardPosition < handCard.size())) {
			// 指定した位置のカードの要素を代入する
			lookingCard = (Card)handCard.get(cardPosition);
		}
		// 指定された位置のカードを返却する
		return lookingCard;
	}
	
	/*
	 * 関数名：pickCard
	 * 概要：カードを引く。引いたカードは手札から削除される。
	 * 引数：int cardPosition
	 * 戻り値：pickedCard
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.28
	 */
	public Card pickCard(int cardPosition) {
		// 文字列にnullを代入する
		Card pickedCard = null;
		
		// 引数で指定された位置が妥当であるかチェックする
		if ((0 <= cardPosition) && (cardPosition < handCard.size())) {
			// 指定された位置のカードを取り除く
			pickedCard = (Card)handCard.remove(cardPosition);
		}
		
		// cardPositionで指定された位置のカード（範囲外ならnull）を返却する
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
