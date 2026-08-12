class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int>ans;
        int temp;
        for(auto i:asteroids){
            if(ans.size()==0){
                ans.push_back(i);
            }else if(ans.back()>=0 && i >=0){
                ans.push_back(i);
            }else if(ans.back()>=0 && i<0){
                temp=ans.back()+i;
                if(temp==0){
                    ans.pop_back();
                } else if(temp<0){
                    while(ans.size()!=0 && ans.back()>0 && ans.back()+i<0){
                        ans.pop_back();
                    }
                    if(ans.size()!=0 && ans.back()<0 &&ans.back()+i!=0){
                        ans.push_back(i);
                    }else if(ans.size()==0){
                        ans.push_back(i);
                    }else if(ans.size()!=0 &&ans.back()+i==0){
                        ans.pop_back();
                    }
                }
            }else if(ans.back()<0){
                ans.push_back(i);
            }
        }
        return ans;
    }
};