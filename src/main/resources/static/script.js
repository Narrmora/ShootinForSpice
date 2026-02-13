const BASE_URL = "";

async function getScore() {
    const response = await fetch(`${BASE_URL}/getscore`);
    const data = await response.json();

    document.getElementById("gameNumber").innerText = data.currentGameNumber;
    document.getElementById("roundNumber").innerText = data.currentRoundNumber;
    document.getElementById("mScore").innerText = data.mScore;
    document.getElementById("rScore").innerText = data.rScore;
}


async function submitRound(playerKey) {

    const prefix = playerKey === "M" ? "m" : "r";

    const payload = {
        playerKey: playerKey,
        twoPlusKills: document.getElementById(prefix + "TwoPlusKills").checked,
        grenadeKill: document.getElementById(prefix + "GrenadeKill").checked,
        zeusKill: document.getElementById(prefix + "ZeusKill").checked,
        knifeKill: document.getElementById(prefix + "KnifeKill").checked,
        smokeDefuse: document.getElementById(prefix + "SmokeDefuse").checked

    };


    await fetch(`${BASE_URL}/submitround`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(payload)
    });

    formElement.reset();

    getScore();
   
}


async function submitBonus(playerKey) {
    const prefix = playerKey === "M" ? "m" : "r";
    const payload = {
        playerKey: playerKey,
        anubisWin: document.getElementById(prefix + "AnubisWin").checked,
        officeWin: document.getElementById(prefix + "OfficeWin").checked,
        clickbait: document.getElementById(prefix + "Clickbait").checked,
        invisible: document.getElementById(prefix + "Invisible").checked,
        sub1k: document.getElementById(prefix + "Sub1k").checked,
        threeKplus: document.getElementById(prefix + "ThreeKplus").checked,
        util100: document.getElementById(prefix + "Util100").checked
    };

    await fetch(`${BASE_URL}/finishgame`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload)
    });

    formElement.reset();

    getScore();


}



window.onload = getScore;
