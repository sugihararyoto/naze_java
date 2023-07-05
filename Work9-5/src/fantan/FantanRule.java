// パッケージ名の宣言
package fantan;

import trump.Card;
import trump.Hand;
import trump.Rule;
import trump.Table;
/**
 * 七並べのルールを表すクラス
 */
/*
 * クラス名:FantanRule
 * 概要  :七並べルールクラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.30
 */
public class FantanRule implements Rule{
	
	/*
	 * 関数名：findCandidate
	 * 概要：テーブルに置けるカードを探す。
	 * 手札とテーブルから、テーブルに出しうるカードの組み合わせを見つける
	 * 引数：Hand handCard, Table cardTable
	 * 戻り値：returnCard
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.30
	 */
	public Card[] findCandidate(Hand handCard, Table cardTable) {
		// カードを返却するための変数を生成する
		Card[] returnCard = null;
		// テーブルのカードを取得する
		Card[][] tableCards = cardTable.getCards();
		
		// 手札の枚数を取得する
		int myCardsNumber = handCard.getNumberOfCards();
		
		// 手札のカードを全て見るまで繰り返す
		for (int i = 0; i < myCardsNumber; i++) {
			// 手札のカードを見る
			Card myHandCard = handCard.lookCard(i);
			
			// スートを取得する
			int handSuit = myHandCard.getSuit();
			// 数を取得する
			int handNumber = myHandCard.getNumber();
			
			// 左隣を判定するための変数
			int leftNumber = 0;
			// 右隣を判定するための変数
			int rightNumber = 0;
			
			// カードの数が1以外の場合
			if (handNumber != 1) {
				// 左隣の数を代入する
				leftNumber = handNumber - 1;
			// カードの数が1の場合
			} else {
				// 左隣の数（13）を代入する
				leftNumber = Card.CARD_NUMBER;
			}
			
			// カードの数が13以外の場合
			if (handNumber != Card.CARD_NUMBER) {
				// 右隣の数を代入する
				rightNumber = handNumber + 1;
			// カードの数が13の場合
			} else {
				// 右隣の数（1）を代入する
				rightNumber = 1;
			}
			// 手札のカードの左右にカードが置いてある場合
			if ((tableCards[handSuit - 1][leftNumber - 1] != null)
					|| (tableCards[handSuit - 1][rightNumber - 1] != null)) {
				// 要素数1のCard型の配列を生成する
				returnCard = new Card[1];
				// 手札からカードを引く
				returnCard[0] = handCard.pickCard(i);
				
				// for文から抜ける
				break;
			}
			
		}
		
		// nullかテーブルに置けるカードを返却する
		return returnCard;
		
	}
	

}