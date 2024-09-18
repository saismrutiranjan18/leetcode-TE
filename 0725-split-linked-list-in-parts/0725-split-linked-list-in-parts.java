/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
                     //Beats 100% on Java runtime, and beats 98.55% on Java memory.
                     
                     
                             // Store all of the nodes in the ArrayList
                                     ArrayList<ListNode> list = new ArrayList<>();
                                     
                                             // Temporary node to traverse the linked list
                                                     ListNode tmp = head;
                                                     
                                                             // Traverse the linked list and store each node in the ArrayList
                                                                     while(tmp!=null){
                                                                                 list.add(tmp);
                                                                                             tmp = tmp.next;
                                                                                                     }
                                                                                                     
                                                                                                             /* This the remainder of the list that you'll have to divide up equally towards the
                                                                                                                      * beginning of your returned array.
                                                                                                                               */
                                                                                                                                       int remainder = list.size() % k;
                                                                                                                                       
                                                                                                                                               /* This is the default size of each piece of the linked list that you'll store 
                                                                                                                                                        * for each index in the array (not including the remainder).
                                                                                                                                                                 */
                                                                                                                                                                         int piece = list.size() / k;
                                                                                                                                                                         
                                                                                                                                                                                 /* This is used to store the size of each part of the array: I needed a separate
                                                                                                                                                                                          * variable apart from 'piece', because of the remainder.
                                                                                                                                                                                                   * Also, I initialize part to -1, because if I don't, then when we traverse the array,
                                                                                                                                                                                                            * we will be traversing ahead of the ArrayList by 1, which will give us the wrong
                                                                                                                                                                                                                     * answer. So, we start behind by 1.
                                                                                                                                                                                                                              */
                                                                                                                                                                                                                                      int part = -1;
                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                              // This is the array that will store the linked lists and will be returned
                                                                                                                                                                                                                                                      ListNode[] ret = new ListNode[k];
                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                              //Comments after this one are ALL for the for-loop
                                                                                                                                                                                                                                                              
                                                                                                                                                                                                                                                                      /* 'i' is for traversing the ArrayList of nodes that we created earlier; it's
                                                                                                                                                                                                                                                                               * corresponding condition is i < list.size().
                                                                                                                                                                                                                                                                                        */
                                                                                                                                                                                                                                                                                                // 'j' is for traversing the 'ret' array; it's corresponding condition is j < k.
                                                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                                                        /* We increment i by part + 1, so that we do not repeat any of the nodes in the 
                                                                                                                                                                                                                                                                                                                 * ArrayList, and this way, we are able to move onto the next section of 
                                                                                                                                                                                                                                                                                                                          * the linked-list.
                                                                                                                                                                                                                                                                                                                                   */
                                                                                                                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                                                                                                                           /* 'part += ((remainder > 0) ? 1 : 0) + piece' allows us to create how large 
                                                                                                                                                                                                                                                                                                                                                    * each part of linked list is, and we also are able to consider the remainder.
                                                                                                                                                                                                                                                                                                                                                             *
                                                                                                                                                                                                                                                                                                                                                                      * I do '+=' because we need to keep traversing the ArrayList in proper sections, 
                                                                                                                                                                                                                                                                                                                                                                               * so we must add the previous value of 'part' to the new value, as well as adding
                                                                                                                                                                                                                                                                                                                                                                                        * 'piece' and to the end as well.
                                                                                                                                                                                                                                                                                                                                                                                                 * 
                                                                                                                                                                                                                                                                                                                                                                                                          * The ternary operator dictates whether we add 1 to 'part' or not.
                                                                                                                                                                                                                                                                                                                                                                                                                   * Then we decrement remainder if it is greater than 0 to ensure that we don't
                                                                                                                                                                                                                                                                                                                                                                                                                            * repeat values in the future
                                                                                                                                                                                                                                                                                                                                                                                                                                     */
                                                                                                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                                                                                                             for(int i = 0, j = 0; i < list.size() && j < k; i = part + 1, j++){
                                                                                                                                                                                                                                                                                                                                                                                                                                                         part += ((remainder > 0) ? 1 : 0) + piece;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ret[j] = list.get(i);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 list.get(part).next = null;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             if(remainder > 0){
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             remainder--;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Lastly, we return the array that contains the split linked list
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 return ret;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     }
}