
let url = Bundle.main.url(forResource: "C:\Users\v3575g\Desktop\\users.json", withExtension: "json")
        
guard let jsonData = url else{return}
guard let data = try? Data(contentsOf: jsonData) else { return }
guard let json = try? JSONSerialization.jsonObject(with: data, options: []) else{return}



if let dictionary = json as? [String: Any] {
            
            if let title = dictionary["name"] as? String {
             for (key, value) in title {
                print("value" )     //parsing title,first and last name
            }
            }
            
            if let dob = dictionary["dob"] as? Double {
                print(dob[age])
            }
        }
