import game.Gamer;
import game.Memento;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Gamer gamer = new Gamer(100);
		/** 最初の状態を保存 */
		Memento memento = gamer.createMemento();
		for (int i = 0; i < 100; i++) {
			System.out.println("===" + i);
			System.out.println("現状:" + gamer);

			gamer.bet();
			System.out.println("所持金は" + gamer.getMoney() + "円になりました");

			if (gamer.getMoney() > memento.getMoney()) {
				memento = gamer.createMemento();
			} else if (gamer.getMoney() < memento.getMoney() / 2) {
				gamer.restoreMemento(memento);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("");
			}
		}
	}

}
