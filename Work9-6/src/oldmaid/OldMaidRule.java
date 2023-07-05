// パッケージ名の宣言
package oldmaid;

import trump.Card;
import trump.Hand;
import trump.Rule;
import trump.Table;

/**
 * ばば抜きのルールを表すクラス
 */
/*
 * クラス名:OldMaidRule
 * 概要  :ばば抜きルールクラス
 * 作成者:R.Sugihara
 * 作成日:2023.07.03
 */
public class OldMaidRule implements Rule{
	/*
	 * 関数名：findCandidate
	 * 概要：テーブルに置けるカードを探す。
	 * 手札とテーブルから、テーブルに出しうるカードの組み合わせを見つける
	 * 引数：Hand handCard, Table cardTable
	 * 戻り値：returnCard
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.03
	 */
	public Card[] findCandidate(Hand handCard, Table cardTable) {
		// 手札の枚数を取得する
		int numberOfCards = handCard.getNumberOfCards();
		// 同じ数を調べるための配列を生成する
		Card[] sameCards = null;
		
		Outer:
		// 手札のカードを確認するための繰り返し文
		for (int i = numberOfCards - 1; i >= 0; i--) {
			// カードを見る
			Card firstCard = handCard.lookCard(i);
			// 手札のカードを確認するための繰り返し文
			for (int k = i - 1; k >= 0; k--) {
				// カードを見る
				Card secondCard = handCard.lookCard(k);
				// 見たカードの数が同じ場合
				if (firstCard.getNumber() == secondCard.getNumber()) {
					// 配列を生成する
					sameCards = new Card[2];
					// 同じ数のカードを引く
					sameCards[0] = handCard.pickCard(i);
					// 同じ数のカードを引く
					sameCards[1] = handCard.pickCard(k);
					// 二つのfor文から抜ける
					break Outer;
				}
			}
		}
		
		// 同じ数の組み合わせを返却する（無い場合はnull）
		return sameCards;
		
	}

}
