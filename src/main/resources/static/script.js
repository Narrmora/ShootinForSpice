const BASE_URL = "";

async function getScore() {
    const response = await fetch(`${BASE_URL}/getscore`);
    const data = await response.json();

    document.getElementById("gameNumber").innerText = data.currentGameNumber;
    document.getElementById("roundNumber").innerText = data.currentRoundNumber;
    document.getElementById("mScore").innerText = data.mScore;
    document.getElementById("rScore").innerText = data.rScore;
}

function openBonusModal() {
    const modal = document.getElementById("bonusModal");
    modal.style.display = "block";
    document.body.classList.add("modal-open");
}

function closeBonusModal() {
    const modal = document.getElementById("bonusModal");
    modal.style.display = "none";
    document.body.classList.remove("modal-open");
    getScore();
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

 document.querySelectorAll(`#roundForm${playerKey} input[type="checkbox"]`)
        .forEach(cb => cb.checked = false);
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
 document.querySelectorAll(`#bonusModal input[type="checkbox"]`)
        .forEach(cb => cb.checked = false);
    closeBonusModal();
    getScore();
}

window.onclick = function(event) {
    const modal = document.getElementById("bonusModal");

    if (event.target === modal) {
        closeBonusModal();
    }
};

window.onload = () => {
    getScore();          // initial load
    setInterval(getScore, 5000);  // update every 5 seconds
};
