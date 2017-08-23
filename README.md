"# autoreboot-gpu-fail-mining" 
- This is extra tool used to monitor and auto reboot PC if GPU mining failed. This can be used associated with ethminer tool or any miner tool does not support mechanism to auto reboot if one of GPU failed mining. When GPU failed mining, PC will be reboot automatically and you need to configure your ethminer (or any miner tool) to kick of as start up program. This would help you save time to monitor and no need to restart mining program manually anymore. 
- This is used for NVIDIA GPUs only
- This need to be installed nvidia-smi command line tool
- So far support autoreboot for Window only since gpu fail mining