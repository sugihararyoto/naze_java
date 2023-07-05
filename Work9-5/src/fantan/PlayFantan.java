// パッケージ名の宣言
package fantan;
import trump.Card;
import trump.Hand;
import trump.Master;
import trump.Player;
import trump.Rule;
import trump.Table;

/**
 * 七並べプログラム
 */
/*
 * クラス名:PlayFantan
 * 概要  :七並べクラス
 * 作成者:R.Sugihara
 * 作成日:2023.07.03
 */
public class PlayFantan {
	/*
	 * 関数名：createtrump
	 * 概要：トランプを生成する
	 * 引数：なし
	 * 戻り値：trumpNumber
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.03
	 */
	private static Hand createtrump() {
		// カードを加えるための手札を生成する
		Hand trumpNumber = new Hand();
		// 各スート52枚のカードを生成する
		for (int i = 1; i <= Card.CARD_NUMBER; i++) {
			// スートがクラブのカードを生成する
			trumpNumber.addCard(new Card(Card.SUIT_CLUB, i));
			// スートがダイヤモンドのカードを生成する
			trumpNumber.addCard(new Card(Card.SUIT_DIAMOND, i));
			// スートがハートのカードを生成する
			trumpNumber.addCard(new Card(Card.SUIT_HEART, i));
			// スートがスペードのカードを生成する
			trumpNumber.addCard(new Card(Card.SUIT_SPADE, i));
		}
		// 生成したカードを返却する
		return trumpNumber;
	}
	/*
	 * 関数名：main
	 * 概要：七並べを行う
	 * 引数：String args[]
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.07.03
	 */
	public static void main(String args[]) {
		// 進行役の生成
		Master masterPlayer = new FantanMaster();
		// テーブルの作成
		Table playTable = new FantanTable();
		// ルールの作成
		Rule gameRule = new FantanRule();
		// プレイヤー村田の生成
		Player murataPlayer = new FantanPlayer("村田", masterPlayer, playTable, gameRule);
		// プレイヤー山田の生成
		Player yamadaPlayer = new FantanPlayer("山田", masterPlayer, playTable, gameRule);
		// プレイヤー斎藤の生成
		Player saitoPlayer = new FantanPlayer("斎藤", masterPlayer, playTable, gameRule);
		// 進行役へプレイヤー村田を登録
		masterPlayer.resisterPlayer(murataPlayer);
		// 進行役へプレイヤー山田を登録
		masterPlayer.resisterPlayer(yamadaPlayer);
		// 進行役へプレイヤー斎藤を登録
		masterPlayer.resisterPlayer(saitoPlayer);
		// トランプを生成する
		Hand playTrump = createtrump();
		// ゲームの準備をする
		masterPlayer.prepareGame(playTrump);
		// ゲームを開始する
		masterPlayer.startGame();
	}

}