package org.zero.algorithm;

/**
 * 求一段时间内最多的在线人数
 */
public class LoginMaxCount {
    public static void main(String[] args) {
        Item[] items = new Item[3];
        items[0] = new Item("A", 4, 6);
        items[1] = new Item("B", 3, 5);
        items[2] = new Item("C", 7, 8);
        System.out.println(maxOnlineUserSize(items, 1, 10));
    }

    static int maxOnlineUserSize(Item[] items, int begin, int end) {
        if(items == null || items.length == 0) {
            return 0;
        }
        int[] users = new int[end - begin + 1];
        for(Item item : items) {
            if(item == null) {
                continue;
            }
            if(item.login >= end || item.logout < begin) {
                continue;
            }
            users[item.login - begin] += 1;
            if(item.logout <= end) {
                users[item.logout - begin] -= 1;
            }
        }
        int curr = users[0];
        int max = users[0];
        for(int i=1; i<users.length; i++) {
            int tmp = curr;
            curr += users[i];
            users[i] = tmp;
            if(max < users[i]) {
                max = users[i];
            }
        }
        return max;
    }

    static class Item {
        String id;
        int login;
        int logout;

        public Item(String id, int login, int logout) {
            this.id = id;
            this.login = login;
            this.logout = logout;
        }
    }
}
