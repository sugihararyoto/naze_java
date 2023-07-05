// パッケージ名の宣言
package oldmaid;

import java.util.ArrayList;

import trump.Card;
import trump.Table;

/**
 * ばば抜きのテーブルを表すクラス
 */
/*
 * クラス名:OldMaidTable
 * 概要  :ばば抜きテーブルクラス
 * 作成者:R.Sugihara
 * 作成日:2023.07.03
 */
public class OldMaidTable implements Table{
	/** 捨てられたカードを保持しておくためのリスト */
	private ArrayList trashCards = new ArrayList();
	/*
	 * 関数名：putCard
	 * 概要：カードを置く（捨てる）
	 * 引数：Card[] oneCard
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.03
	 */
	public void putCard(Card[] oneCard) {
		// カードを捨てるための繰り返し文
		for (int i = 0; i < oneCard.length; i++) {
			// 捨てられたカードを表示する
			System.out.print(oneCard[i] + " ");
			// 捨てられたカードはリストに追加して保持しておく
			trashCards.add(oneCard[i]);
		}
		// カードを捨てたことを伝える
		System.out.println("を捨てました");
		

	}
	/*
	 * 関数名：getCards
	 * 概要：カードを見る。
	 * 引数：なし
	 * 戻り値：cardTable
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.03
	 */
	public Card[][] getCards() {
		// カードを見ないため、nullを返却する
		return null;
		
	}

}
