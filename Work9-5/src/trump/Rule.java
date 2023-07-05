// パッケージ名の宣言
package trump;
/**
 * トランプルールインタフェース
 * 現在の手札とテーブルから、出しうるカードの組み合わせを見つける。
 */
/*
 * インタフェース名:Rule
 * 概要  :ルールインタフェース
 * 作成者:R.Sugihara
 * 作成日:2023.06.28
 */
public interface Rule {
	/**
	 * テーブルに置けるカードを探す。
	 * 手札とテーブルから、テーブルに出しうるカードの組み合わせを見つける
	 * 
	 * @param handCard 手札
	 * @param cardTable テーブル
	 * @return 見つかったカードの組み合わせ。見つからなかった場合はnullを返す
	 */
	public Card[] findCandidate(Hand handCard, Table cardTable);

}
