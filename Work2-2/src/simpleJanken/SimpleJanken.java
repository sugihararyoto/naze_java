//パッケージ名の宣言
package simpleJanken;
/**
 * オブジェクト指向を使用しないジャンケンプログラム
 */
/*
 * クラス名:SimpleJanken
 * 概要  :ジャンケンクラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.23
 */
public class SimpleJanken {
	//ジャンケンの手を表す定数
	//グー
	public static final int STONE_NUMBER = 0;
	//チョキ
	public static final int SCISSORS_NUMBER = 1;
	//パー
	public static final int PAPER_NUMBER = 2;
	
	/* 関数名：main
	 * 概要：オブジェクト指向を使用しないジャンケンプログラム
	 * 引数：なし
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.23
	 */
	// ■■■■■■■■■■■■■■■■■
	//   プログラムのスタートはここから
	// ■■■■■■■■■■■■■■■■■
	public static void main(String[] args) {
		// プレイヤー1の勝ち数
		int player1WinCount = 0;
		// プレイヤー2の勝ち数
		int player2WinCount = 0;
		
		// ■■■■■■■■■■■■■■■■■■■■
		//   ① プログラムが開始したことを表示する
		// ■■■■■■■■■■■■■■■■■■■■
		// プログラム開始メッセージを表示する
		System.out.println("【ジャンケン開始】\n");
		
		// ジャンケンを3回実施する
		// ■■■■■■■■■■■■■■
		//   ⑥ 勝負した回数を加算する
		//   ⑦ 3回勝負が終わったか？
		// ■■■■■■■■■■■■■■
		for (int i = 0; i < 3; i++) {
			
			// 何回戦目かを表示する
			System.out.println("【" + (i + 1) + "回戦目】");
			
			// 乱数を格納するための変数
			double randomNumber = 0;
			
			// ■■■■■■■■■■■■■■■■■■
			//   ② プレイヤー1が何を出すか決める
			// ■■■■■■■■■■■■■■■■■■
			int player1Hand = 0;
			
			// 0以上3未満の少数として乱数を得る
			randomNumber = Math.random() * 3;
			
			// randomNumberが0.0以上1.0未満の場合
			if (randomNumber < 1) {
				// グーを出す
				player1Hand = STONE_NUMBER;
				
				// プレイヤー1の手を表示する
				System.out.print("グー");
			// randomNumberが1.0以上2.0未満の場合
			} else if (randomNumber < 2) {
				// チョキを出す
				player1Hand = SCISSORS_NUMBER;
				
				// プレイヤー1の手を表示する
				System.out.print("チョキ");
			// randomNumberが2.0以上3.0未満の場合
			} else if (randomNumber < 3) {
				// パーを出す
				player1Hand = PAPER_NUMBER;
				
				// プレイヤー1の手を表示する
				System.out.print("パー");
			}
			
			// ■■■■■■■■■■■■■■■■■■
			//   ③ プレイヤー2が何を出すか決める
			// ■■■■■■■■■■■■■■■■■■
			int player2Hand = 0;
			
			// 0以上3未満の少数として乱数を得る
			randomNumber = Math.random() * 3;
			
			// randomNumberが0.0以上1.0未満の場合
			if (randomNumber < 1) {
				// グーを出す
				player2Hand = STONE_NUMBER;
				
				// プレイヤー2の手を表示する
				System.out.print(" vs. グー");
			// randomNumberが1.0以上2.0未満の場合
			} else if (randomNumber < 2) {
				// チョキを出す
				player2Hand = SCISSORS_NUMBER;
				
				// プレイヤー2の手を表示する
				System.out.print(" vs. チョキ");
			// randomNumberが2.0以上3.0未満の場合
			} else if (randomNumber < 3) {
				// パーを出す
				player2Hand = PAPER_NUMBER;
				
				// プレイヤー2の手を表示する
				System.out.print(" vs. パー");
			}
			
			
			// ■■■■■■■■■■■■■■■■■■■■■■
			//   ④ どちらが勝ちかを判定し、結果を表示する
			// ■■■■■■■■■■■■■■■■■■■■■■
			// プレイヤー1が勝つ場合
			if (	(player1Hand == STONE_NUMBER && player2Hand == SCISSORS_NUMBER)
				||	(player1Hand == SCISSORS_NUMBER && player2Hand == PAPER_NUMBER)
				||	(player1Hand == PAPER_NUMBER && player2Hand == STONE_NUMBER)) {
				// ■■■■■■■■■■■■■■■■■■■■
				//   ⑤ プレイヤー1の勝った回数を加算する
				// ■■■■■■■■■■■■■■■■■■■■
				player1WinCount++;
				
				// ジャンケンの結果を表示する
				System.out.println("\nプレイヤー1が勝ちました！\n");
			// プレイヤー2が勝つ場合
			} else if (	(player1Hand == STONE_NUMBER && player2Hand == PAPER_NUMBER)
					||	(player1Hand == SCISSORS_NUMBER && player2Hand == STONE_NUMBER)
					||	(player1Hand == PAPER_NUMBER && player2Hand == SCISSORS_NUMBER)) {
				// ■■■■■■■■■■■■■■■■■■■■
				//   ⑤ プレイヤー2の勝った回数を加算する
				// ■■■■■■■■■■■■■■■■■■■■
				player2WinCount++;
				
				// ジャンケンの結果を表示する
				System.out.println("\nプレイヤー2が勝ちました！\n");
			// 引き分けの場合
			} else {
				// ジャンケンの結果を表示する
				System.out.println("\n引き分けです！\n");
			}
			
		}
		
		// ■■■■■■■■■■■■■■■■■■■■■
		//   ⑧ 最終的な勝者を判定し、画面に表示する
		// ■■■■■■■■■■■■■■■■■■■■■
		System.out.println("【ジャンケン終了】\n");
		
		// プレイヤー1の勝ち数が多いとき
		if (player1WinCount > player2WinCount) {
			// プレイヤー1の勝ちを表示する。
			System.out.println(player1WinCount + "対" + player2WinCount
					+ "でプレイヤー1の勝ちです！\n");
		// プレイヤー2の勝ち数が多いとき
		} else if (player1WinCount < player2WinCount) {
			// プレイヤー2の勝ちを表示する。
			System.out.println(player1WinCount + "対" + player2WinCount
					+ "でプレイヤー2の勝ちです！\n");
		// プレイヤー1と2の勝ち数が同じとき
		} else if (player1WinCount == player2WinCount) {
			// 引き分けを表示する。
			System.out.println(player1WinCount + "対" + player2WinCount
					+ "で引き分けです！\n");
		}
	}

}
