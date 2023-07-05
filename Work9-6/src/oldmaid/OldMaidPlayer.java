// パッケージ名の宣言
package oldmaid;

import trump.Card;
import trump.Hand;
import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

/**
 * ばば抜き用プレイヤークラス
 */
/*
 * クラス名:OldMaidPlayer
 * 概要  :ばば抜きプレイヤークラス
 * 作成者:R.Sugihara
 * 作成日:2023.07.03
 */
public class OldMaidPlayer extends Player{
	/** 裏側から見た手札を表すクラス */
//	private BackHand backHandCard = new BackHand(myHandCard);
	
	/*
	 * 関数名：OldMaidPlayer
	 * 概要：コンストラクタ
	 * 引数：String playerName, Master masterPlayer, Table playTable, Rule gameRule
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.03
	 */
	public OldMaidPlayer(String playerName, Master masterPlayer, Table playTable, Rule gameRule) {
		// クラスPlayerのコンストラクタの呼出し
		super(playerName, masterPlayer, playTable, gameRule);
	}
	/*
	 * 関数名：receiveCard
	 * 概要：カードを配る
	 * 引数：Card oneCard(受け取ったカード)
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.03
	 */
	@Override public void receiveCard(Card oneCard) {
		// カードを手札に追加する
		super.receiveCard(oneCard);
		// テーブルに出せるカードを探す
		Card[] tableCards = gameRule.findCandidate(myHandCard, playTable);
		
		// 出せるカードがある場合
		if (tableCards != null) {
			// カードを置いた人を伝える
			System.out.print(this + "：");
			// カードを置く
			playTable.putCard(tableCards);
		}
		
	}
	
	/*
	 * 関数名：nominatePlayer
	 * 概要：順番を指名するメソッド
	 * 引数：Player nextPlayer
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.04
	 */
	public void nominatePlayer(Player nextPlayer) {
		// 次のプレイヤーに手札を出してもらう
		Hand nextPlayerHand = ((OldMaidPlayer)nextPlayer).showHand();
		
		// 相手の手札からカードを1枚引く
		int NumberOfHands = nextPlayerHand.getNumberOfCards();
		
		// ランダムな位置からカードを1枚抜き取る
		Card pickedCard = nextPlayerHand.pickCard((int)(Math.random() * NumberOfHands));
		
		// 引いた結果を表示
		System.out.println(this + "：" + nextPlayer + "さんから" + pickedCard + "を引きました");
		
		// 引いたカードを自分の手札に加える
		myHandCard.addCard(pickedCard);
		
		// テーブルに出せるカードを探す
		Card[] tableCards = gameRule.findCandidate(myHandCard, playTable);
		
		// 出せるカードがある場合
		if (tableCards != null) {
			// カードを置いた人を伝える
			System.out.print(this + "：");
			// カードを置く
			playTable.putCard(tableCards);
		}
		
		// 手札がゼロになったかどうか調べる
		if (myHandCard.getNumberOfCards() == 0) {
			// 進行役に上がりを宣言する
			masterPlayer.declareWin(this);
			
		// 手札がまだある場合
		} else {
			// 現在の手札を表示する
			System.out.println(this + "：残りの手札は" + myHandCard + "です");
		}
		
	}
	/*
	 * 関数名：showHand
	 * 概要：手札を出す
	 * 引数：なし
	 * 戻り値：backHandCard
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.04
	 */
	public Hand showHand() {
		// もしこの時点で手札が残り1枚ならば上がりとなるので宣言する
		if (myHandCard.getNumberOfCards() == 1) {
			// 進行役に上がりを宣言する
			masterPlayer.declareWin(this);
		}
		
		// 見せる前にシャッフルする
		myHandCard.shuffleCard();
		// 手札を返却する
		return myHandCard;
		
	}

}
