// パッケージ名の宣言
package trump;
/**
 * テーブルを表すインタフェース
 */
/*
 * インタフェース名:Table
 * 概要  :テーブルインタフェース
 * 作成者:R.Sugihara
 * 作成日:2023.06.28
 */
public interface Table {
	/**
	 * カードを置く。
	 * テーブルに置かれたカードをどのように扱うかは、サブクラスで実装する。
	 * 
	 * @param tableCard カード
	 */
	public void putCard(Card[] tableCard);
	
	/**
	 * カードを見る
	 * 
	 * @return テーブルに置かれたカードを表す配列
	 */
	public Card[][] getCards();

}
