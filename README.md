# JSON parsing test

This is a quick attempt to test json parsing performances of Logan Square and GSON.

# Result:
- Logan Square does not use reflection but uses pre-processor to serialize and de-serialize JSON. So we can expect better performance in terms of speed at the cost of more binary size. This project confirms that and I found it to be 5x faster than gson for my sample size and sample data. Results are encouraging if you dont mind the extra bits it brings in.

- If you are invested in GSON heavily and dont want to move, my other experiment might be of interest to you. I tried to use mitigate the biggest problem with GSON, which is 'reflection'. Reflections are bad because, at runtime, the VM will not do optimizations it can do otherwise. It will try to find a matching method using signature, find the method address and call it as apposed to knowing the address before. Reflections are great because there are libraries like gson that do not need to know much about your model but still can do your model serialization.

In order to get the best out of both, i.e., use GSON but without reflection, I tried my hand with type adapters. Usinf type adapters you can custom write the way you want to serialize and deserialize your data eliminating the need for reflections. Since you write your parsing logic, your code will be succint. 

Here is a snapshot of the results:
```xml
https://docs.google.com/spreadsheets/d/1gLJwpah1yKhWC6kyFQ56cg_7wORdKeCzm4jnWOqKglA/edit?usp=sharing
```

On an average, I got a 90ms gain by using my own type adapters. I would take that.

License
=======


    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
