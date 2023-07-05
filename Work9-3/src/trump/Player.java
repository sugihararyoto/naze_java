package trump;

/**
 * プレイヤークラス
 */
/*
 * クラス名:Player
 * 概要  :プレイヤークラス
 * 作成者:R.Sugihara
 * 作成日:2023.06.28
 */
public abstract class Player {
	/** 名前 */
	protected String playerName;
		
	/** フィールド */
	protected Table playTable;
	
	/** 手札 */
	protected Hand myHandCard = new Hand();
	
	/** 進行役 */
	protected Master masterPlayer;
	
	/** ルール */
	protected Rule gameRule;
	
	/*
	 * 関数名：Player
	 * 概要：コンストラクタ
	 * 引数：String playerName, Master masterPlayer, Table playTable, Rule gameRule
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.27
	 */
	public Player(String playerName, Master masterPlayer, Table playTable, Rule gameRule) {
		// フィールドに引数の値を代入する
		this.playerName = playerName;
		// フィールドに引数の値を代入する
		this.masterPlayer = masterPlayer;
		// フィールドに引数の値を代入する
		this.playTable = playTable;
		// フィールドに引数の値を代入する
		this.gameRule = gameRule;
	}
	
	/*
	 * 関数名：nominatePlayer
	 * 概要：順番を指名する抽象メソッド
	 * 引数：Player nextPlayer
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	public abstract void nominatePlayer(Player nextPlayer);
	
	/*
	 * 関数名：receiveCard
	 * 概要：カードを配る
	 * カードを受け取った時の処理を拡張したい場合は、
	 * 本メソッドをサブクラスでオーバーライドすること。
	 * 引数：Card oneCard
	 * 戻り値：なし
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	public void receiveCard(Card oneCard) {
		// 受け取ったカードを手札に加える
		myHandCard.addCard(oneCard);
	}
	
	/*
	 * 関数名：toString
	 * 概要：プレイヤーの名前を返す
	 * 引数：なし
	 * 戻り値：playerName
	 * 作成者：R.Sugihara
	 * 作成日：2023.06.29
	 */
	@Override public String toString() {
		// プレイヤーの名前を返却する
		return playerName;
	}

}
