// id: 1146
// Name: Snapshot Array
// link: https://leetcode.com/problems/snapshot-array/
// Difficulty: Medium

class SnapshotArray {

    int snapId = 0;
    TreeMap<Integer, Integer> [] historyRecords;

    public SnapshotArray(int length) {
        historyRecords = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            historyRecords[i] = new TreeMap<Integer, Integer> ();
            historyRecords[i].put(0,0);
        }
    }
    
    public void set(int index, int val) {
        historyRecords[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return (int) historyRecords[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
