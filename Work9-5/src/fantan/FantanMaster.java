// パッケージ名の宣言
package fantan;

import trump.Master;
/**
 * 七並べの進行役クラス
 */
/*
 * クラス名:FantanMaster
 * 概要  :七並べ進行役クラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.30
 */
public class FantanMaster extends Master{
	/** パスできる制限回数 */
	public static final int PASS_LIMIT = 3;
	
	/*
	 * 関数名：passPlayer
	 * 概要：パスを宣言する
	 * 引数：FantanPlayer onePlayer
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.30
	 */
	public void passPlayer(FantanPlayer onePlayer) {
		// パスしたことを表示
		System.out.println(" " + onePlayer + "さんは" 
				+ onePlayer.getPass() + "回目のパスをしました！");
		
		// パス回数が制限値を超えている場合
		if (onePlayer.getPass() > PASS_LIMIT) {
			// 負けたことを伝える
			System.out.println(" " + onePlayer + "さんは負けです！");
			// プレイヤーを除外する
			deregisterPlayer(onePlayer);
		}
		
		
	}
	

}