// パッケージ名の宣言
package fantan;

import trump.Card;
import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

/**
 * 七並べ用プレイヤークラス
 */
/*
 * クラス名:FantanPlayer
 * 概要  :七並べプレイヤークラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.30
 */
public class FantanPlayer extends Player{
	
	/** パスした回数 */
	private int passNumber;
	
	/*
	 * 関数名：FantanPlayer
	 * 概要：コンストラクタ
	 * 引数：String playerName, Master masterPlayer, Table playTable, Rule gameRule
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.30
	 */
	public FantanPlayer(String playerName, Master masterPlayer, Table playTable, Rule gameRule) {
		// クラスPlayerのコンストラクタの呼出し
		super(playerName, masterPlayer, playTable, gameRule);
	}
	
	/*
	 * 関数名：receiveCard
	 * 概要：カードを配る
	 * 引数：Card oneCard(受け取ったカード)
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.30
	 */
	@Override public void receiveCard(Card oneCard) {
		// 受け取ったカードの数が7の場合
		if (oneCard.getNumber() == 7) {
			// カードを置いたことを伝える
			System.out.println(playerName + "：" + oneCard + "を置きました。");
			
			// カードを置く
			playTable.putCard(new Card[] {oneCard});
		// そうでない場合
		} else {
			// カードを手札に追加する
			super.receiveCard(oneCard);
		}
	}
	
	/*
	 * 関数名：nominatePlayer
	 * 概要：順番を指名する
	 * 引数：Player nextPlayer
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	public void nominatePlayer(Player nextPlayer) {
		// 現在の手札を表示する
		System.out.println("  " + myHandCard);
		
		// 現在の手札からテーブルに出せるものを探す
		Card[] tableCards = gameRule.findCandidate(myHandCard, playTable);
		
		// 出せるカードがある場合はテーブルに出す
		if (tableCards != null) {
			// カードを置いたことを伝える
			System.out.println("  " + tableCards[0] + "を置きました。\n");
			// カードを置く
			playTable.putCard(tableCards);
			
			// テーブルの状態を表示する
			System.out.println(playTable);
			
			// 手札がなくなった場合
			if (myHandCard.getNumberOfCards() == 0) {
				// 上がりを宣言する
				masterPlayer.declareWin(this);
			}
		// 出せるカードがなかった場合
		} else {
			// パスをする
			passNumber++;
			// パスをする
			((FantanMaster)masterPlayer).passPlayer(this);
			
			// パス回数が制限を超える場合
			if (passNumber > FantanMaster.PASS_LIMIT) {
				// 手札の数を数える
				int NumberOfCard = myHandCard.getNumberOfCards();
				// 全て置くための繰り返し文
				for (int i = 0; i < NumberOfCard; i++) {
					// 手札をテーブルに置く
					playTable.putCard(new Card[] { myHandCard.pickCard(0) });
				}
			}
			
		}
		
	}
	
	/*
	 * 関数名：getPass
	 * 概要：パス回数を数える
	 * 引数：なし
	 * 戻り値：passNumber
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.30
	 */
	public int getPass() {
		// パスした回数を返却する
		return passNumber;
	}
	
	

}