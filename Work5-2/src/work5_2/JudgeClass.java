//パッケージ名の宣言
package work5_2;
/**
 * ジャンケンの審判を表すクラス
 */
/*
 * クラス名:JudgeClass
 * 概要  :審判クラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.26
 */
public class JudgeClass {
	/*
	 * 関数名：startJanken
	 * 概要：ジャンケンを開始する
	 * 引数：PlayerClass player1, PlayerClass player2
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	public void startJanken(PlayerClass player1, PlayerClass player2) {
		// ジャンケンの開始を宣言する
		System.out.println("【ジャンケン開始】\n");
		
		// ジャンケンを3回行う
		for (int i = 0; i < 3; i++) {
			// 何回戦目か表示する
			System.out.println("【" + (i + 1) + "回戦目】");
			
			// プレイヤーの手を見て、どちらが勝ちかを判定する
			PlayerClass winnerPlayer = judgeJanken(player1, player2);
			
			// 勝者が存在する場合
			if (winnerPlayer != null) {
				// 勝者を表示する
				System.out.println("\n" + winnerPlayer.getName() + "が勝ちました！\n");
				
				// 勝ったプレイヤーへ結果を伝える
				winnerPlayer.notifyResult(true);
				
			// 引き分けの場合
			} else {
				// 引き分けの場合
				System.out.println("\n引き分けです！\n");
			}
		}
		
		// ジャンケンの終了を宣言する
		System.out.println("【ジャンケン終了】\n");
		
		// 最終的な勝者を判定する
		PlayerClass finalWinner = judgeFinalWinner(player1, player2);
		
		// 結果の表示
		System.out.print(player1.getWinCount() + "対" + player2.getWinCount() + "で");
		
		// 勝者が存在する場合
		if (finalWinner != null) {
			// 勝者を表示する
			System.out.println(finalWinner.getName() + "の勝ちです！\n");
		// 引き分けの場合
		} else {
			// 引き分けの場合
			System.out.println("引き分けです！\n");
		}
		
	}
	
	/*
	 * 関数名：startJanken
	 * 概要：ジャンケンを開始する
	 * 引数：PlayerClass player1, PlayerClass player2
	 * 戻り値：winnerPlayer
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	private PlayerClass judgeJanken(PlayerClass player1, PlayerClass player2) {
		// 勝敗を判定する変数winnerPlayerを生成し、nullで初期化する
		PlayerClass winnerPlayer = null;
		
		// プレイヤー1の手を出す
		int player1hand = player1.showHand();
		// プレイヤー2の手を出す
		int player2hand = player2.showHand();
		
		// プレイヤー1の手を表示する
		printHand(player1hand);
		// 画面にvs.と表示する
		System.out.print(" vs. ");
		// プレイヤー2の手を表示する
		printHand(player2hand);
		// 改行する
		System.out.print("\n");
		
		// プレイヤー1が勝つ場合
		if ((player1hand == PlayerClass.STONE_NUMBER && player2hand == PlayerClass.SCISSORS_NUMBER)
				|| (player1hand == PlayerClass.SCISSORS_NUMBER && player2hand == PlayerClass.PAPER_NUMBER)
				|| (player1hand == PlayerClass.PAPER_NUMBER && player2hand == PlayerClass.STONE_NUMBER)) {
			// 勝者をプレイヤー1にする
			winnerPlayer = player1;
		// プレイヤー2が勝つ場合
		} else if ((player1hand == PlayerClass.STONE_NUMBER && player2hand == PlayerClass.PAPER_NUMBER)
				|| (player1hand == PlayerClass.SCISSORS_NUMBER && player2hand == PlayerClass.STONE_NUMBER)
				|| (player1hand == PlayerClass.PAPER_NUMBER && player2hand == PlayerClass.SCISSORS_NUMBER)) {
			// 勝者をプレイヤー2にする
			winnerPlayer = player2;
		}
		
		// どちらでもない場合は引き分け（nullを返す）
		return winnerPlayer;
		
	}
	
	/*
	 * 関数名：judgeFinalWinner
	 * 概要：最終的な勝者を判定する
	 * 引数：PlayerClass player1, PlayerClass player2
	 * 戻り値：winnerPlayer
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	private PlayerClass judgeFinalWinner(PlayerClass player1, PlayerClass player2) {
		// 勝敗を判定する変数winnerPlayerを生成し、nullで初期化する
		PlayerClass winnerPlayer = null;
		
		// Player1から勝ち数を聞く
		int player1WinCount = player1.getWinCount();
		// Player2から勝ち数を聞く
		int player2WinCount = player2.getWinCount();
		
		// プレイヤー1が勝っている場合
		if (player1WinCount > player2WinCount) {
			// プレイヤー1の勝ち
			winnerPlayer = player1;
		// プレイヤー2が勝っている場合
		} else if (player1WinCount < player2WinCount) {
			// プレイヤー2の勝ち
			winnerPlayer = player2;
		}
		// どちらでもない場合は引き分け（nullを返す）
		return winnerPlayer;
		
	}
	
	/*
	 * 関数名：printHand
	 * 概要：ジャンケンの手を表示する
	 * 引数：int playerHand
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.26
	 */
	private void printHand(int playerHand) {
		// 出した手によって分岐する
		switch (playerHand) {
			// 出した手がグーの場合
			case PlayerClass.STONE_NUMBER:
				// 画面にグーと表示する
				System.out.print("グー");
				// switch文から抜ける
				break;
			// 出した手がチョキの場合
			case PlayerClass.SCISSORS_NUMBER:
				// 画面にチョキと表示する
				System.out.print("チョキ");
				// switch文から抜ける
				break;
			// 出した手がパーの場合
			case PlayerClass.PAPER_NUMBER:
				// 画面にパーと表示する
				System.out.print("パー");
				// switch文から抜ける
				break;
			// それ以外の場合
			default :
				// switch文から抜ける
				break;
		}
	}

}
