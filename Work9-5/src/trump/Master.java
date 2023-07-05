package trump;

import java.util.ArrayList;
/**
 * 進行役を表すクラス
 */
/*
 * クラス名:Master
 * 概要  :進行役クラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.27
 */
public class Master {
	/** プレイヤーのリスト */
	private ArrayList playersList = new ArrayList();
	
	/*
	 * 関数名：prepareGame
	 * 概要：ゲームの準備をする
	 * 引数：Hand cards
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public void prepareGame(Hand gameCards) {
		// カードを配ることを伝える
		System.out.println("【カードを配ります】");
		
		// トランプをシャッフルする
		gameCards.shuffleCard();
		
		// トランプの枚数を取得する
		int numberOfCards = gameCards.getNumberOfCards();
		
		// プレイヤーの人数を取得する
		int numberOfPlayers = playersList.size();
		// プレイヤーの人数分、処理を繰り返す
		for (int index = 0; index < numberOfCards; index++) {
			// カードから1枚引く
			Card allCard = gameCards.pickCard(0);
			
			// 各プレイヤーに順番にカードを配る
			Player allPlayer = (Player) playersList.get(index % numberOfPlayers);
			// カードを配るメソッドを呼び出す
			allPlayer.receiveCard(allCard);
		}
		
	}
	
	/*
	 * 関数名：startGame
	 * 概要：ゲームを開始する
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public void startGame() {
		// ゲームを開始することを伝える
		System.out.println("\n【ゲームを開始します】");
		
		// プレイヤーの人数を取得する
		for (int count = 0; playersList.size() > 1; count++) {
			// 指名するプレイヤーを代入する
			int playerIndex = count % playersList.size();
			// 次のプレイヤーを代入する
			int nextPlayerIndex = (count + 1) % playersList.size();
			
			// 指名するプレイヤーの取得
			Player selectPlayer = (Player) playersList.get(playerIndex);
			
			// 次のプレイヤーの取得
			Player nextplayer = (Player) playersList.get(nextPlayerIndex);
			
			// プレイヤーを指名する
			System.out.println("\n" + selectPlayer + "さんの番です");
			// 順番を指名するメソッドを呼び出す
			selectPlayer.nominatePlayer(nextplayer);
		}
		
		// プレイヤーが上がって残り1名になるとループを抜ける
		System.out.println("【ゲームを終了しました】");
	}
	
	/*
	 * 関数名：declareWin
	 * 概要：上がりを宣言する
	 * 引数：Player winnerPlayer
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public void declareWin(Player winnerPlayer) {
		// 上がったプレイヤー
		System.out.println(winnerPlayer + "さんが上がりました！");
		
		// 上がったプレイヤーをリストから外す
		deregisterPlayer(winnerPlayer);
		
	}
	
	/*
	 * 関数名：resisterPlayer
	 * 概要：ゲームに参加するプレイヤーを登録する。
	 * 引数：Player onePlayer
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public void resisterPlayer(Player onePlayer) {
		// リストに参加者を追加する
		playersList.add(onePlayer);
	}
	
	/*
	 * 関数名：deregisterPlayer
	 * 概要：ゲームに参加するプレイヤーを登録から削除する。
	 * 勝ったプレイヤーをゲームから抜くときに使用する。
	 * 引数：Player onePlayer
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	public void deregisterPlayer(Player onePlayer) {
		// リストから参加者を削除する
		playersList.remove(playersList.indexOf(onePlayer));
		
		// 残りプレイヤーが1人になった時は敗者を表示する
		if (playersList.size() == 1) {
			// 負けたプレイヤーを取得する
			Player loserPlayer = (Player) playersList.get(0);
			// 敗者を伝える
			System.out.println(loserPlayer + "さんの負けです！");
		}
	}

}
